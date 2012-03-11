/**
 * This file is part of Kowy Maker.
 * 
 * Kowy Maker is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Kowy Maker is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Kowy Maker. If not, see <http://www.gnu.org/licenses/>.
 */
package com.kokakiwi.kintell.spec.utils.maths;

public class MathsHelper
{
    public static int supervise(int value, int min, int max)
    {
        int newValue = value;
        
        if (newValue > max)
        {
            newValue = max;
        }
        
        if (newValue < min)
        {
            newValue = min;
        }
        
        return newValue;
    }
    
    public static double supervise(double value, double min, double max)
    {
        double newValue = value;
        
        if (newValue > max)
        {
            newValue = max;
        }
        
        if (newValue < min)
        {
            newValue = min;
        }
        
        return newValue;
    }
}
