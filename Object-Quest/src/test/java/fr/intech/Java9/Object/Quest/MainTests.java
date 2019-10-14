package fr.intech.Java9.Object.Quest;

import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import fr.intech.Java9.Object.Quest.model.RequestResponse;
import fr.intech.Java9.Object.Quest.service.ObjectRecognition;
import fr.intech.Java9.Object.Quest.service.ResponseHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

	@Autowired
	VisionApi visionApi;
	@Autowired
	ResponseHandler responseHandler;

	@Autowired
	ObjectRecognition objectRecognition;

	@Test
	public void contextLoads() {
	}

	@Test
	public void sendRequest() throws Exception {

//		BatchAnnotateImagesResponse res  = visionApi.sendRequest(getClass().getResourceAsStream("/mouse.jpg"));
//
//		System.out.println(res);
	}

	@Test
	public void response() throws  Exception {
		BatchAnnotateImagesResponse res  = visionApi.sendRequest(getClass().getResourceAsStream("/mouse.jpg"));

		RequestResponse response = responseHandler.getResponseFromApi(res);
	System.out.println(response);
	}

	@Test
	public void display() throws Exception{

		BatchAnnotateImagesResponse res  = visionApi.sendRequest(getClass().getResourceAsStream("/mouse.jpg"));

		//System.out.println(res);
//		try {
//			new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).writeValue(System.out,res);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Test
	public void des() throws Exception{
		BatchAnnotateImagesResponse res  = visionApi.sendRequest(getClass().getResourceAsStream("/mouse.jpg"));

		RequestResponse response = responseHandler.getResponseFromApi(res);

		objectRecognition.ObjectIs(response);

		System.out.println(response.getDescriptions().toString());

		//assertEquals(objectRecognition.ObjectExistAndNotFound(response), true);

	}
}
