package fr.intech.Java9.Object.Quest;

import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import fr.intech.Java9.Object.Quest.model.RequestResponse;
import fr.intech.Java9.Object.Quest.service.ResponseHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

	@Autowired
	VisionApi visionApi;
	@Autowired
	ResponseHandler responseHandler;

	@Test
	public void contextLoads() {
	}

	@Test
	public void sendRequest() throws Exception {

		BatchAnnotateImagesResponse res  = visionApi.sendRequest(getClass().getResourceAsStream("/mouse.jpg"));

		System.out.println(res);
	}

	@Test
	public void response() throws  Exception {
		BatchAnnotateImagesResponse res  = visionApi.sendRequest(getClass().getResourceAsStream("/mouse.jpg"));

		RequestResponse response = responseHandler.getResponse(res);
	System.out.println(response);
	}
}
