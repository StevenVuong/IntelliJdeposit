package midTermExam;

import java.io.*;
import java.net.*;
import java.util.*;

public class year2013 {

	public static BufferedReader brFromURL(String url) throws MalformedURLException, IOException {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}
	
	public static String get_Data (ArrayList<Double> data) {
		
		StringBuilder ss = new StringBuilder();
		ss.append("\nYear: "+data.get(0));
		
		for (int i = 1; i < data.size() -1; i++) {
			ss.append("\nMonth: "+i+": "+data.get(i));
		}
		ss.append("\nAnnual: "+data.get(13));
		return ss.toString();
	}
	
	public static ArrayList<Double> parseLine(String line) {
		ArrayList<Double> data_array = new ArrayList<>();
		Scanner sc = new Scanner(line);

		while(sc.hasNext()) {
			String token = sc.next();
			//if (token.equals("2012")) break;
			data_array.add(Double.parseDouble(token));
		}
		return data_array;
	}

	public static ArrayList<ArrayList<Double>> dataFromURL(BufferedReader br) throws IOException{
		ArrayList<ArrayList<Double>> data_tot = new ArrayList<>();
		String line = "";

		while((line = br.readLine()) != null) {
			if(Character.isLetter(line.charAt(0))) continue;
			ArrayList<Double> data_line = parseLine(line);
			if(!(data_line.isEmpty())) data_tot.add(data_line);
		}
		return data_tot;		
	}

	public static void wettest_month(ArrayList<ArrayList<Double>> data_tot) {
		double max_rain = Double.MIN_VALUE;
		ArrayList<Double> max_info = new ArrayList<>();
		double max_month = 0;
		for (ArrayList<Double> ann: data_tot) {
			for(int i = 1; i < 13; i++) {
				double rain_val = ann.get(i);
				if (rain_val > max_rain) {
					max_rain = rain_val;
					max_info = ann; max_month = i;
				}
			}
		}
		System.out.println("Wettest Month: "+max_month + get_Data(max_info));
	}

	public static void monthly_analysis(ArrayList<ArrayList<Double>> data_tot) {
		for (int i = 1; i < 13; i++) {
			double max_rain = Double.MIN_VALUE;
			double min_rain = Double.MAX_VALUE;
			double rain_sum = 0;
			double rain_sum_square = 0;
			for (ArrayList<Double> ann: data_tot) {
				double rain_val = ann.get(i);
				if (rain_val > max_rain) max_rain = rain_val;
				else if (rain_val < min_rain) min_rain = rain_val;
				rain_sum += rain_val;
				rain_sum_square += rain_val*rain_val;
			}
			double av_rain = rain_sum/data_tot.size();
			double RMS_rain = Math.sqrt(rain_sum_square/data_tot.size());
			System.out.println("\nFor month: " +i+ " |max rain: "+max_rain+" |min rain: "+min_rain+" |av rain: "+av_rain+
					" |RMS: "+RMS_rain);
		}
	}

	public static void wettest_3_months(ArrayList<ArrayList<Double>> data_tot) {
		double max_rain = Double.MIN_VALUE;
		ArrayList<Double> index_year = null;
		int final_month = 0;
		for (int j = 0; j < data_tot.size(); j++) {
			ArrayList<Double> ann = data_tot.get(j);
			for (int i = 3; i < 13; i++) {
				double three_rain = ann.get(i)+ann.get(i-1)+ann.get(i-2);
				if (three_rain > max_rain) {
					max_rain = three_rain; index_year = ann; final_month = i;
				}
			}
		}
		System.out.println("\nWettest 3-month period between months "+(final_month-2)+", "+(final_month-1)+
				", "+(final_month)+" Quantity: "+max_rain+" Year: "+index_year.get(0));
	}


	public static void final_year_analysis(ArrayList<ArrayList<Double>> data_tot) {
		double num_points = data_tot.size();
		ArrayList<Double> final_year = data_tot.get(data_tot.size()-1);
		int counter = 0;
		
		for (int i = 1; i < 13; i++) {
			counter = 0;
			for (int j = 0; j < data_tot.size()-1 ; j++) {
				ArrayList<Double> ann = data_tot.get(j);
				if(ann.get(i) > final_year.get(i)) {
					counter++;
				}
			}
			double percentage = 100*(counter/num_points);
			System.out.println("\n For month: "+i+" |Percentage: "+percentage+"%");
		}
	}

	public static void main(String[] args) {
		try {
			BufferedReader br = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2012-13/HadEWP_monthly_qc.txt");
			ArrayList<ArrayList<Double>> data_tot_mod = dataFromURL(br);
			ArrayList<ArrayList<Double>> data_tot = data_tot_mod;
			data_tot_mod.remove(data_tot_mod.size()-1);

			wettest_month(data_tot_mod);
			monthly_analysis(data_tot_mod);
			wettest_3_months(data_tot_mod);
			final_year_analysis(data_tot);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
