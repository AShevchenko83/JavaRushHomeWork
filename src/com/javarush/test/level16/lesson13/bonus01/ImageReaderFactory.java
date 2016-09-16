package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Admin on 01.06.16.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader (ImageTypes t) throws IllegalArgumentException
    {
        if(t==ImageTypes.BMP)
            return new BmpReader();
        else if (t==ImageTypes.JPG)
            return new JpgReader();
        else if(t==ImageTypes.PNG)
            return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");

    }
}
