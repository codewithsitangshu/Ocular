package com.org.codewithsitangshu.eyeSpy.sample;

import com.org.codewithsitangshu.eyeSpy.comparator.EyeSpyResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.Path;
import java.util.List;

public interface SampleBuilder {
    public SampleBuilder using(WebDriver driver);
    public SampleBuilder using(Path path);
    public SampleBuilder element(WebElement element);
    public SampleBuilder excluding(WebElement element);
    public SampleBuilder excluding(List<WebElement> list);
    public SampleBuilder similarity(int cutoff);
    public EyeSpyResult compare();
}