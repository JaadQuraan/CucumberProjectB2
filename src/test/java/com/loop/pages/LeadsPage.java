package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeadsPage extends DocuportBasePage{

    @FindBy(xpath = "//div[@class='v-select__selection v-select__selection--comma']")
    public WebElement rowsPerPageAmount;

    @FindBy(xpath = "//div[@tabindex='-1']/div")
    public List<WebElement> rowsPerPageList;

    public Integer getRowsPerPageAmount(){
        String amountText = rowsPerPageAmount.getText();
        return Integer.parseInt(amountText);
    }

    public Integer changeRowsPerPageAmount(Integer newAmount){
        getRowsPerPageAmount();

        for(WebElement option : rowsPerPageList){
            if(option.getText().equals(newAmount.toString())){
                option.click();
                break;
            }
        }

        return Integer.parseInt(rowsPerPageList.get(1).getText());
    }

    public LeadsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
