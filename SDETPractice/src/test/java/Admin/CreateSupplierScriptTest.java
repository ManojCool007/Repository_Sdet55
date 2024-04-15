package Admin;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.inventory.sales.objectrepository.CreateSupplierPage;
import com.inventory.sales.objectrepository.HomePage;
import com.inventory.sales.objectrepository.SupplierInfoPage;

public class CreateSupplierScriptTest extends BaseClass {
	
	@Test
	public void script() throws IOException, InterruptedException
	{
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSupplierLink();
		
		SupplierInfoPage supplierInfoPage = new SupplierInfoPage(driver);
		supplierInfoPage.clickOnSupplierLookUpImg();
		
		String Comp_value = exutil.readDataFromExcel("Sheet2", 0, 1);
		String province = exutil.readDataFromExcel("Sheet2", 1, 1);
		String city = exutil.readDataFromExcel("Sheet2", 2, 1);
		String number = exutil.readDataFromExcel("Sheet2", 3, 1);
		
		CreateSupplierPage createSupplierPage = new CreateSupplierPage(driver);
		
		WebElement sel_province = createSupplierPage.getSelect_Province();
		webutil.dropDown(sel_province, province);
		WebElement sel_city = createSupplierPage.getSelect_City();
		webutil.dropDown(sel_city, city);
		createSupplierPage.enterAllDetailsAndSave(Comp_value, province, city, number);

	}
}
