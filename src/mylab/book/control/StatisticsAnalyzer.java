package mylab.book.control;

import java.util.Map;

import mylab.book.entity.Publication;

public class StatisticsAnalyzer {
	
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
		
	}
	
	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
		
	}
	
	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
		
	}
	
	private String getPublicationType(Publication pub) {
		
	}
	
	public void printStatistics(Publication[] publications) {
		
		System.out.println("===== 출판물 통계 분석 =====");
		System.out.println("1. 타입별 평균 가격:");
		System.out.println("- 소설: " + "원");
		System.out.println("- 참고서:" + "원");
		System.out.println("");
		System.out.println("- 잡지: " + "원");
		System.out.println("");
		System.out.println("2. 출판물 유형 분포:");
		System.out.println("- 소설: " + "원");
		System.out.println("- 참고서:" + "원");
		System.out.println("- 잡지: " + "원");
		System.out.println("");
		System.out.println("3. 2007년에 출판된 출판물 비율:" + "%");	
		
	}


}
