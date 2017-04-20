package com.ttn.poc;

import com.ttn.poc.upload.UploadImageRequest;
import com.ttn.poc.upload.UploadImageResponse;
import com.ttn.poc.upload.UploadOption;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by neetesh on 4/4/17.
 */
public class CloudinaryAsyncApiTest implements CloudinaryAsyncApi.ApiCallback<UploadImageResponse> {
    String publicId = "111/222/333/444";
    String format = "png";

    CloudinaryAsyncApi api;

    List<String> list = Arrays.asList(
            "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-1-iz842yz4-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-1-iz842yz4-m2.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-1-izsrqrp4-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-1-izsrqrp4-m2.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-1-j0287yyg-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-1-j0du05ps-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-1-j0du05ps-m2.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-1-j0du05ps-m3.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-1-j0j73wu0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-10-iz8dq014-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-10-j0ibw7wg-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-11-iz8gzy68-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-11-j0ibwfm8-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-12-iz8gzy68-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-12-j0ibwnc0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-13-iz8h03ko-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-14-iz8h03ko-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-15-iz8i2ako-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-16-iz8i2ako-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-16-j0isw6rk-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-17-iz9o1dhs-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-17-j0iswehc-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-18-iz9o3mig-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-18-j0iswm74-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-19-j0itipq0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-2-iz84689c-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-2-iz84689c-m2.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-2-izto6sb4-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-2-izto6sb4-m2.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-2-j03g1snk-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-2-j0du05ps-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-2-j0j73wu0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-20-j0itiy7k-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-21-j0itj5xc-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-3-iz884s7c-m1.jpg"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-3-j0du05ps-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-3-j0j73wu0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-30-j0v9zyw0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-31-j0v9zyw0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-32-j0v9zyw0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-33-j0vaa2bc-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-34-j0vaa2bc-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-35-j0vaa2bc-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-36-j0vajte8-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-37-j0vajte8-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-38-j0vajte8-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-39-j0vaohls-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-4-iz884s7c-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-4-j0dwai80-m1.jpg"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-4-j0dwai80-m2.jpg"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-40-j0vaohls-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-41-j0vaohls-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-42-j0vawki0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-43-j0vawki0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-44-j0vawki0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-45-j0vb4btk-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-46-j0vb4btk-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-47-j0vb4btk-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-48-j0w3x67k-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-49-j0w3x67k-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-5-iz89fqsg-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-5-j0dwai80-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-5-j0dwai80-m2.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-50-j0w3x67k-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-51-j0w40kw8-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-53-j0w56eao-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-54-j0w56eao-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-55-j0w5ash4-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-56-j0wf2vmo-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-57-j0wf2vmo-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-58-j0wf2vmo-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-59-j0xbyubc-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-6-iz89qqmg-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-60-j0xbyubc-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-61-j0xbyubc-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-68-j0z45r7s-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-69-j0z45r7s-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-7-iz8agbx4-m1.jpg"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-7-iz8agbx4-m2.jpg"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-70-j0z45r7s-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-71-j0z72df4-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-72-j0z72df4-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-73-j0z72df4-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-74-j11rzh14-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-75-j11rzh14-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-76-j11veabs-m1.jpg"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-77-j11veabs-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-78-j11x19s8-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-79-j11x1hi0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-8-iz8agbx4-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-8-iz8agbx4-m2.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-80-j11x1p7s-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-81-j11xmx3s-m1.jpg"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-81-j11xmx3s-m2.jpg"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-82-j11xmx3s-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-82-j11xmx3s-m2.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-86-j123hjo0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-89-j123lvj4-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-9-iz8dpwy0-m1.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-9-iz8dpwy0-m2.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-9-iz8dpwy0-m3.png"
            , "http://tank.tskytech.com/Jumpstart/Temp/mezzanine/imageContent-90-j123m9f4-m1.png");

    @Before
    public void setup() {
        api = new CloudinaryAsyncApi(CommonUtil.CONFIG);
    }

    @Test
    public void testUploadApi() {
       /* for (int i = 0; i < 2; i++) {
            UploadImageRequest request = new UploadImageRequest(list.get(i));
            request.addOption(UploadOption.PUBLIC_ID, "provider/video/image_" + i);
            api.upload(request, this);
        }*/

        UploadImageRequest request = new UploadImageRequest(list.get(0));
        request.addOption(UploadOption.PUBLIC_ID, "provider/video/image_00");
        api.upload(request, this);

        System.out.println("Requests sent");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onApiResponse(UploadImageResponse response) {
        System.out.println(response);
        assertNotNull(response);
        assertTrue(response.isSuccess());
    }
}
