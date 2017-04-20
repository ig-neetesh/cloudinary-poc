package com.ttn.poc;

import com.ttn.poc.delete.DeleteImageRequest;
import com.ttn.poc.delete.DeleteImageResponse;
import com.ttn.poc.transform.TransformImageRequest;
import com.ttn.poc.transform.TransformImageResponse;
import com.ttn.poc.upload.UploadImageRequest;
import com.ttn.poc.upload.UploadImageResponse;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by neetesh on 4/4/17.
 */
public class CloudinaryAsyncApi {
    private ExecutorService service = Executors.newFixedThreadPool(5);

    private CloudinaryApi api;

    public CloudinaryAsyncApi(Map config) {
        api = CloudinaryApi.INSTANCE.configure(config);
    }

    public void upload(final String imageUrl, final Map options, final ApiCallback<Map> onUpload) {
        service.submit(new Runnable() {
            public void run() {
                Map response = api.upload(imageUrl, options);
                onUpload.onApiResponse(response);
            }
        });
    }

    public void upload(final UploadImageRequest request, final ApiCallback<UploadImageResponse> onUpload) {
        service.submit(new Runnable() {
            public void run() {
                UploadImageResponse response = api.upload(request);
                onUpload.onApiResponse(response);
            }
        });
    }

    public void delete(final String publicId, final Map options, final ApiCallback<Map> onDelete) {
        service.submit(new Runnable() {
            public void run() {
                Map response = api.delete(publicId, options);
                onDelete.onApiResponse(response);
            }
        });
    }

    public void delete(final DeleteImageRequest request, final ApiCallback<DeleteImageResponse> onDelete) {
        service.submit(new Runnable() {
            public void run() {
                DeleteImageResponse response = api.delete(request);
                onDelete.onApiResponse(response);
            }
        });
    }

    public void transformImage(final String imageTag, final Map options, final ApiCallback<String> onTransform) {
        service.submit(new Runnable() {
            public void run() {
                String response = api.transformImage(imageTag, options);
                onTransform.onApiResponse(response);
            }
        });
    }

    public void transformImage(final TransformImageRequest request, final ApiCallback<TransformImageResponse> onTransform) {
        service.submit(new Runnable() {
            public void run() {
                TransformImageResponse response = api.transformImage(request);
                onTransform.onApiResponse(response);
            }
        });
    }

    public static interface ApiCallback<T> {
        void onApiResponse(T response);
    }
}
