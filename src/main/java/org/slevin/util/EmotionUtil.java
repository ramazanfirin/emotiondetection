package org.slevin.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slevin.common.Emotion;
import org.slevin.common.Face;

public class EmotionUtil {
public static List<Face> parseEmotionResult(String string) throws ParseException{
	List<Face> faceList=  new ArrayList<Face>();
	
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(string);

	JSONArray jsonArray = (JSONArray) obj;
	//faceCount = jsonArray.size()+"";
	
	for (int i = 0; i < jsonArray.size(); i++) {
		Face face = new Face();
		
		JSONObject jsonObject = (JSONObject)jsonArray.get(i);
		JSONObject jsonObjectRect = (JSONObject)jsonObject.get("faceRectangle");
		
		String top=jsonObjectRect.get("top").toString();
		String left=jsonObjectRect.get("left").toString();
		String width=jsonObjectRect.get("width").toString();
		String heigth=jsonObjectRect.get("height").toString();
		String result=left+","+top+","+width+","+heigth;
		
		face.setHeightValue(new Long(heigth));
		face.setTopValue(new Long(top));
		face.setLeftValue(new Long(left));
		face.setWidthvalue(new Long(width));
		
		
		JSONObject jsonObjectScores = (JSONObject)jsonObject.get("scores");
		String contempt = jsonObjectScores.get("contempt").toString();
		String surprise = jsonObjectScores.get("surprise").toString();
		String happiness = jsonObjectScores.get("happiness").toString();
		String neutral = jsonObjectScores.get("neutral").toString();
		String sadness = jsonObjectScores.get("sadness").toString();
		String disgust = jsonObjectScores.get("disgust").toString();
		String anger = jsonObjectScores.get("anger").toString();
		String fear = jsonObjectScores.get("fear").toString();
		
		Emotion emotion = new Emotion();
		emotion.setAnger(new Double(anger));
		emotion.setContempt(new Double(contempt));
		emotion.setDisgust(new Double(disgust));
		emotion.setFear(new Double(fear));
		emotion.setHappiness(new Double(happiness));
		emotion.setNeutral(new Double(neutral));
		emotion.setSadness(new Double(sadness));
		emotion.setSurprise(new Double(surprise));
		emotion.setInsertDate(new Date());
		emotion.setInsertTime(new Date());
		emotion.setInsertDateTime(new Date());
		
		String resultEmotion = calculateResultEMotion(emotion);
		emotion.setResult(resultEmotion);
		
		face.getEmotionList().add(emotion);
		faceList.add(face);
	}
	
	return faceList;
	
}

public static String calculateResultEMotion(Emotion emotion){
	double temp=0;
	String result="";
	if(emotion.getAnger()>temp){
		temp = emotion.getAnger();
		result= "Anger";
	}
	
	if(emotion.getContempt()>temp){
		temp = emotion.getContempt();
		result= "Contempt";
	}
	
	if(emotion.getDisgust()>temp){
		temp = emotion.getDisgust();
		result= "Disgust";
	}
	
	if(emotion.getFear()>temp){
		temp = emotion.getFear();
		result= "Fear";
	}
	
	if(emotion.getHappiness()>temp){
		temp = emotion.getHappiness();
		result= "Happiness";
	}
	
	if(emotion.getNeutral()>temp){
		temp = emotion.getNeutral();
		result= "Neutral";
	}
	
	if(emotion.getSadness()>temp){
		temp = emotion.getSadness();
		result= "Sadness";
	}
	
	if(emotion.getSurprise()>temp){
		temp = emotion.getSurprise();
		result= "Surprise";
	}
	
	return result;
	
}
}
