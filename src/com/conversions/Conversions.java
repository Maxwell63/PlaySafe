package com.conversions;

public class Conversions {
	
	private static enum CONVERSION_TYPE {
		CTOK, KTOC, KMTOM, MTOKM
	}
	
	private static float compute(CONVERSION_TYPE c_type, float val) {
		float result = 0f;
		switch (c_type) {
		case KTOC:
			result = val - 273.15f;
			break;
		case CTOK:
			result = val + 273.15f;
			break;
		case MTOKM:
			result = val * 1.60934f;
			break;
		case KMTOM:
			result = val * 0.621371f;
			break;			
		default:
			break;
		}
		
		return result;
	}
	
    //kelvin to celcius
    public String ktoc(float kelvin){
            String output = "";
            try{
                    float celcius = compute(CONVERSION_TYPE.KTOC, kelvin);

                    output = String.format("%.2fK is %.2f Degrees Celcius", kelvin, celcius);
            }
            catch (Exception e){
            	output = String.format("An error has occured %s", e.getMessage());
            }

            return output;
    }

    //celsius to kelvin
    public String ctok(float celcius){
            String output = "";
            try{
                    float kelvin = compute(CONVERSION_TYPE.CTOK, celcius);

                    output = String.format("%.2f Degrees Celcius is %.2fK", celcius, kelvin);
            }
            catch (Exception e){
                    output = String.format("An error has occured %s", e.getMessage());
            }	

            return output;
    }

    //miles to km
    public String mtokm(float miles){
            String output = "";
            try{
                    double km =  compute(CONVERSION_TYPE.MTOKM, miles);

                    output = String.format("%.2fmi is %.2fkm", miles, km);
            }
            catch (Exception e){
                    output = String.format("An error has occured %s", e.getMessage());
            }

            return output;
    }

    //km to miles
    public String kmtom(float km){
            String output = "";
            try{
                    float miles = compute(CONVERSION_TYPE.KMTOM, km);

                    output = String.format("%.2fkm is %.2fmi", km, miles);
            }
            catch (Exception e){
                    output = "An error has occured" + e.getMessage();
            }

            return output;
    }
}
