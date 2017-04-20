package com.ttn.poc;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.Uploader;
import com.cloudinary.api.*;
import com.cloudinary.utils.ObjectUtils;
import com.ttn.poc.delete.DeleteImageRequest;
import com.ttn.poc.delete.DeleteImageResponse;
import com.ttn.poc.transform.TransformImageRequest;
import com.ttn.poc.transform.TransformImageResponse;
import com.ttn.poc.upload.UploadImageRequest;
import com.ttn.poc.upload.UploadImageResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by neetesh on 3/4/17.
 */
public interface CloudinaryApi {

    CloudinaryApi INSTANCE = Impl.INSTANCE;

    CloudinaryApi configure(Map config);

    Map upload(String imageUrl, Map options);

    UploadImageResponse upload(UploadImageRequest request);

    Map delete(String publicId, Map options);

    DeleteImageResponse delete(DeleteImageRequest request);

    String transformImage(String imageTag, Map options);

    TransformImageResponse transformImage(TransformImageRequest request);

    enum Impl implements CloudinaryApi {
        INSTANCE {
            private Cloudinary cloudinary;
            private Uploader uploader;

            public CloudinaryApi configure(Map config) {
                cloudinary = new Cloudinary(config);
                uploader = cloudinary.uploader();
                return this;
            }

            public Map upload(String imageUrl, Map options) {
                Map response = null;
                try {
                    response = uploader.upload(imageUrl, options);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }

            public UploadImageResponse upload(UploadImageRequest request) {
                Map map = upload(request.getImageUrl(), request.getOptions());
                return new UploadImageResponse(map);
            }

            public Map delete(String publicId, Map options) {
                Map response = null;
                try {
                    response = uploader.destroy(publicId, options);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }

            public DeleteImageResponse delete(DeleteImageRequest request) {
                Map response = delete(request.getPublicId(), request.getOptions());
                boolean success = "ok".equals(response.get("result").toString().toLowerCase());
                return new DeleteImageResponse(request.getPublicId(), success);
            }

            public String transformImage(String imageTag, Map options) {
                return cloudinary.url().transformation(new Transformation().params(options)).generate(imageTag);
            }

            public TransformImageResponse transformImage(TransformImageRequest request) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String response = transformImage(request.getImageTag(), request.getOptions());
                return new TransformImageResponse(response);
            }
        }

    }
}
