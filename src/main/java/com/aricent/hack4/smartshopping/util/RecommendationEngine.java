package com.aricent.hack4.smartshopping.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import weka.associations.Apriori;
import weka.associations.AprioriItemSet;
import weka.core.Instances;
import weka.core.Option;
import weka.core.converters.JSONLoader;

public class RecommendationEngine {

	public static final String TRAIN_DATASETPATH = "C:\\My_Data\\eclipse-workspace\\SmartShoppingML\\src\\main\\resources\\beverages_2.json";
	private static final String SPLIT_REGEX = "=\\d\\s[\\d]*";

	/*
	 * public static void main(String[] args) throws Exception {
	 * System.out.println(recommend("pepsi,frooti")); }
	 */
	public static List<String> recommend(String selectedInputItems) throws Exception {
		String[] inputsArr = selectedInputItems.split(",");
		List<String> inputs = Arrays.asList(inputsArr);
		
		Apriori aprModel = new Apriori();

		System.out.println("=========listOptions()==========");
		Enumeration<Option> enumeration = aprModel.listOptions();
		while (enumeration.hasMoreElements()) {
			Option option = enumeration.nextElement();
			System.out.println("option: " + option.name() + ", Description: " + option.description());
		}
		System.out.println("=========================");

		// json loader
		JSONLoader jsonLoader = new JSONLoader();
		jsonLoader.setFile(new File(TRAIN_DATASETPATH));
		Instances trainDataSets = jsonLoader.getDataSet();
		//
		// DataSource trainData = new DataSource(TRAIN_DATASETPATH);
		// Instances trainDataSets = trainData.getDataSet();

		String options[] = { "-Z" };
		aprModel.setOptions(options);

		aprModel.buildAssociations(trainDataSets);

		System.out.println(aprModel);
		System.out.println("=========================");
		Instances instances = aprModel.getInstancesNoClass();
		// System.out.println("aprModel.getInstancesNoClass():
		// "+aprModel.getInstancesNoClass());

		System.out.println("=====================");
		ArrayList<Object>[] rules = aprModel.getAllTheRules();
		/*
		 * for (ArrayList<Object> arrayList : rules) { for (Object object : arrayList) {
		 * AprioriItemSet itemSet = (AprioriItemSet) object;
		 * System.out.println(itemSet.toString(instances)); }
		 * 
		 * }
		 */
		ArrayList<Object> buyingPattern = rules[0];
		ArrayList<Object> recommendation = rules[1];
		List<String> result = new ArrayList<>();
		for (int index = 0; index < aprModel.getNumRules(); index++) {
			Object buyObj = buyingPattern.get(index);
			Object recoObj = recommendation.get(index);

			AprioriItemSet buyItemSet = (AprioriItemSet) buyObj;
			AprioriItemSet recoItemSet = (AprioriItemSet) recoObj;

			String selectedItem = buyItemSet.toString(instances);
			String[] selectedItems = selectedItem.split(SPLIT_REGEX);
			
			//String selectedResult = String.join(",", selectedItems);
			List<String> selectedResult = Arrays.asList(selectedItems);

			String recommendedItem = recoItemSet.toString(instances);
			String[] recommendedItems = recommendedItem.split(SPLIT_REGEX);

			String recommendedResult = String.join(",", recommendedItems);

			
			if (selectedResult.containsAll(inputs)) {
				System.out.println("You can also buy: " + recommendedResult);
				result.add(recommendedResult);
			}
		}

		return result;
	}
}
