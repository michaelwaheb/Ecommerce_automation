# Amazon Automation Project

This project automates an e-commerce scenario on **Amazon Egypt (https://www.amazon.eg/)** using **Selenium**, **TestNG**, and **Maven**. The framework also integrates **Allure** for test reporting.

## Automation Scenario

The project automates the following user journey:

1. **Login to Amazon**: Open the website and log in.
2. **Navigate to Video Games**: Open the "All" menu and navigate to "Video Games" > "All Video Games".
3. **Apply Filters**: Use the filter menu to apply:
   - **Free Shipping**
   - **Condition: New**
4. **Sort Products**: Sort the results by **Price: High to Low**.
5. **Add Products to Cart**:
   - Add all products priced below **15,000 EGP** to the cart.
   - If no product is below this price, navigate to the next page.
6. **Validate Cart**:
   - Verify that all selected products are in the cart.
7. **Checkout**:
   - Add an address.
   - Choose "Cash" as the payment method.
8. **Verify Total Cost**:
   - Ensure the total cost (including shipping fees, if applicable) matches the sum of the product prices.

---

## Prerequisites

### Software Requirements

1. **Java Development Kit (JDK)**: Version 8 or later.
2. **Maven**: For managing dependencies and running the tests.
3. **Google Chrome** and **ChromeDriver**: Ensure ChromeDriver matches your browser version.
4. **Allure**: For generating test reports.

### Dependencies
The project uses the following libraries:

- **Selenium**: For web automation.
- **TestNG**: For test execution.
- **Allure**: For test reporting.

All dependencies are managed via Maven.

---

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/michaelwaheb/Ecommerce_automation.git
   cd Ecommerce_automation
   ```

2. **Open in IDE**:
   - Import the project as a Maven project in your IDE.

3. **Install Dependencies**:
   - Maven will automatically resolve the dependencies when you load the `pom.xml` file. To force download:
     ```bash
     mvn clean install
     ```

---

## Configuration

 **Allure Reporting**:
   - Ensure Allure is installed:
     ```bash
     brew install allure # For macOS
     choco install allure # For Windows
     ```

---

## Running the Tests

1. **From IDE**:
   - Right-click on the test class or package and select `Run`.

2. **From Command Line**:
   ```bash
   mvn clean test
   ```
**Kindly note before running test make sure you added a valid Test Mail and password for Amazon account in **:
3. **Allure Report generating automatically after run**:
  


