package com.conversions;

public class Conversions {
    //kelvin to celcius
    public String ktoc(float kelvin){
            String output = "";
            try{
                    double celcius = kelvin - 273.15f;

                    output = String.format("%.2fK is %.2f Degrees Celcius", kelvin, celcius);
            }
            catch (Exception e){
            	output = String.format("An error has occured %s", e.getMessage());
            }

            return output;
    }

}
