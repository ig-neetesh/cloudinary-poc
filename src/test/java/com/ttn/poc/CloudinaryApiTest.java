package com.ttn.poc;

import com.ttn.poc.delete.DeleteImageRequest;
import com.ttn.poc.delete.DeleteImageResponse;
import com.ttn.poc.delete.DeleteOption;
import com.ttn.poc.transform.TransformImageRequest;
import com.ttn.poc.transform.TransformImageResponse;
import com.ttn.poc.transform.TransformOption;
import com.ttn.poc.upload.UploadImageRequest;
import com.ttn.poc.upload.UploadImageResponse;
import com.ttn.poc.upload.UploadOption;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by neetesh on 31/3/17.
 */
public class CloudinaryApiTest {
    String publicId = "111/222/333/444";
    String format = "png";

    @Before
    public void setup() {
        CloudinaryApi.INSTANCE.configure(CommonUtil.CONFIG);
    }

    @Test
    public void testApiUpload() {
        String imgLoc = "https://www.hello.com/img_/hello_logo_hero.png";

        UploadImageRequest request = new UploadImageRequest(imgLoc);
        request.addOption(UploadOption.PUBLIC_ID, publicId);

        UploadImageResponse response = CloudinaryApi.INSTANCE.upload(request);

        System.out.println(response);

        assertNotNull(response);
        assertTrue(response.isSuccess());
    }

    @Test
    public void testApiDelete() {
        DeleteImageRequest request = new DeleteImageRequest(publicId);
        request.addOption(DeleteOption.INVALIDATE, true);

        DeleteImageResponse response = CloudinaryApi.INSTANCE.delete(request);

        System.out.println(response);

        assertNotNull(response);
        assertTrue(response.isSuccess());
    }

    @Test
    public void testApiTransform() {
        TransformImageRequest request = new TransformImageRequest(publicId, format);
        request.addOption(TransformOption.HEIGHT, 50);
        request.addOption(TransformOption.CROP, TransformOption.Crop.PAD.getApiParam());

        TransformImageResponse response = CloudinaryApi.INSTANCE.transformImage(request);

        System.out.println(response.getUrl());

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertNotNull(response.getUrl());
    }

}
