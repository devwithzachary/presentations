---
marp: true
header: 'Building Serverless Apps with AppGallery Connect'
footer: '@devwithzachary'
---

<!-- class: invert -->

# <!--fit--> 🖥️ < ?

---

- Cloud Computing++
- Direct access to a service
- No server maintenance/overhead
- AWS Lambda, Google Cloud Functions, Microsoft Azure Functions

---

# Useful for Mobile Development, but why?

---

- Low initial overhead
- Free tiers
- Focus on App Development
- Secure
- Automatic Scaling

---

# Huawei's Offerings, geared towards mobile development

---

- **Cloud DB** - Object Database with seamless synchronization between local device and CloudDB
- **Cloud Storage** - Scalable file static storage
- **Cloud Hosting** - Host webapps and static web pages.
- **Cloud Functions** - Serverless computing power for your applications

---

# CloudDB

Supported Platforms:

- Android - ```implementation 'com.huawei.agconnect:agconnect-cloud-database'```
- iOS - CocoaPods - ```pod 'AGConnectDatabase'```
- Web - ```npm install --save @agconnect/database```

Server SDKS:

- Java - ```implementation 'com.huawei.agconnect.server:agconnect-database-server-sdk'```
- Javascript - ```npm install --save @agconnect/database-server```


---

## Setup

```java
public static void initAGConnectCloudDB(Context context) {
    AGConnectCloudDB.initialize(context);
}
```

```java
mCloudDB = AGConnectCloudDB.getInstance();
mCloudDB.createObjectType(ObjectTypeInfoHelper.getObjectTypeInfo());
```

---

## Web portal

![width:1100px](cloudb-config.png)

---

## Web portal

```json
{
   "objectTypes":[
      {
         "indexes":[
         ],
         "objectTypeName":"BookInfo",
         "fields":[
            {
               "isNeedEncrypt":false,
               "fieldName":"id",
               "notNull":true,
               "belongPrimaryKey":true,
               "fieldType":"Integer"
            },
         ]
      }
   ]
}
```

---
## Export

```java
@PrimaryKeys({"id"})
@Indexes({"bookName:bookName"})
public final class BookInfo extends CloudDBZoneObject {
    private Integer id;
    private String bookName;
    private String author;
    private Double price;
    private String publisher;
    private Date publishTime;
    @DefaultValue(booleanValue = true)
    private Boolean shadowFlag;
    public BookInfo() {
        super(BookInfo.class);
        this.shadowFlag = true;
    }
```
---

## Write

```java
public void upsertBookInfos(BookInfo bookInfo) {
    Task<Integer> upsertTask = mCloudDBZone.executeUpsert(bookInfo);
    upsertTask.addOnSuccessListener(new OnSuccessListener<Integer>() {
        @Override
        public void onSuccess(Integer cloudDBZoneResult) {
            Log.i(TAG, "Upsert " + cloudDBZoneResult + " records");
        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(Exception e) {
            mUiCallBack.updateUiOnError("Insert book info failed");
        }
    });
}
```

---

## Query

```java
    public void queryAllBooks() {
        Task<CloudDBZoneSnapshot<BookInfo>> queryTask = mCloudDBZone.executeQuery(
                CloudDBZoneQuery.where(BookInfo.class),
                CloudDBZoneQuery.CloudDBZoneQueryPolicy.POLICY_QUERY_FROM_CLOUD_ONLY);

        queryTask.addOnSuccessListener(new OnSuccessListener<CloudDBZoneSnapshot<BookInfo>>() {
            @Override
            public void onSuccess(CloudDBZoneSnapshot<BookInfo> snapshot) {
                processQueryResult(snapshot);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                mUiCallBack.updateUiOnError("Query book list from cloud failed");
            }
        });
    }

    private void processQueryResult(CloudDBZoneSnapshot<BookInfo> snapshot) {
        CloudDBZoneObjectList<BookInfo> bookInfoCursor = snapshot.getSnapshotObjects();
        List<BookInfo> bookInfoList = new ArrayList<>();
        try {
            while (bookInfoCursor.hasNext()) {
                BookInfo bookInfo = bookInfoCursor.next();
                bookInfoList.add(bookInfo);
            }
        } catch (AGConnectCloudDBException e) {
            Log.w(TAG, "processQueryResult: " + e.getMessage());
        } finally {
            snapshot.release();
        }
        //DO something with the list
    }

```

---

# Cloud Storage

Supported Platforms:

- Android - ```implementation 'com.huawei.agconnect:agconnect-storage'```
- iOS - CocoaPods - ```pod 'AGConnectStorage'```
- Web - ```npm install --save @agconnect/cloudstorage```

Server SDKS:

- Java - ```implementation 'com.huawei.agconnect.server:agconnect-storage-server-sdk'```
- Javascript - ```npm install --save @agconnect/cloudstorage-server```

---

## Setup

```Java
AGCStorageManagement storageManagement = AGCStorageManagement.getInstance();
AGConnectOptions cnOptions = new AGConnectOptionsBuilder().setRoutePolicy(AGCRoutePolicy.CHINA).build(this);
AGConnectInstance cnInstance = AGConnectInstance.buildInstance(cnOptions);
AGCStorageManagement storageManagement= AGCStorageManagement.getInstance(cnInstance, "bucket name");
```

```Java
StorageReference reference = storageManagement.getStorageReference();
//or
StorageReference reference = storageManagement.getStorageReference("images/demo.jpg");
//or
StorageReference reference = storageManagement.getReferenceFromUrl(AGConnectInstance.getInstance(), "https://xxxxxx");
```

---

## Upload

```Java
UploadTask task = reference.putFile(new File("path/images/test.jpg"));
task.addOnFailureListener(new OnFailureListener(){
    @Override
    public void onFailure(@NonNull Exception exception) {
    }
}).addOnSuccessListener(new OnSuccessListener<UploadTask.UploadResult>(){
    @Override
    public void onSuccess(UploadTask.UploadResult uploadResult) {
    }
});
```

---

## Listing Files

```java
Task<ListResult> listTask = storageManagement.getStorageReference("images/").listAll();
ListResult listResult = Tasks.await(listTask);
StorageReference reference = listResult.getFileList().get(0);
Task<FileMetadata> metaTask = reference.getFileMetadata();
```

## Delete Files
```Java
reference.delete();
```

---

## Download File

```Java
StorageReference reference = storageManagement.getStorageReference("images/demo.jpg");
File file = new File("path/images/test.jpg");
DownloadTask task = reference.getFile(file);
task.addOnFailureListener(new OnFailureListener(){
    @Override
    public void onFailure(@NonNull Exception exception) {
    }
}).addOnSuccessListener(new OnSuccessListener<DownloadTask.DownloadResult>(){
    @Override
    public void onSuccess(DownloadTask.DownloadResult downloadResult) {
    }
});
```

---

# Cloud Hosting

Host static generated web apps and websites.
Version controlled by default.
One-Click Deployment
Access Accerlation via CDN
Secure config free certificate

---

# Cloud Functions

Supported Platforms:

- Android - ```implementation 'com.huawei.agconnect:agconnect-function'```
- iOS - CocoaPods - ```pod 'AGConnectFunction'```
- Web - ```npm install --save @agconnect/function```

Cross Platform:

- Flutter - ```apply plugin: 'com.huawei.agconnect'```
- React Native - ```npm install @react-native-agconnect/cloudfunctions```
- Cordova - ```cordova plugin add @cordova-plugin-agconnect/cloudfunctions```

---

# But wait there is more!

Remote Configurations, App Messaging, App Linking, A/B Testing, Auth Service, Connect API, Crash, APM, Cloud Testing...

---

# Thank you!

INSERT QR CODE FOR https://developer.huawei.com/consumer/en/agconnect/

INSERT QR CODE FOR https://linktr.ee/devwithzachary

