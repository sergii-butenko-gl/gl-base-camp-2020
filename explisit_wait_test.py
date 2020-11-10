from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
url = "https://www.globallogic.com/ua/careers"
driver.get(url)

search_input = driver.find_element_by_id("by_keyword")
search_input.send_keys("QA" + Keys.RETURN)

try:
    element = WebDriverWait(driver, 10).until(
        EC.presence_of_all_elements_located((By.CLASS_NAME, "ongo"))
    )
    results = driver.find_elements_by_class_name("career-pagelink")
    print(results[0].find_element_by_class_name("mb-0").text)

finally:
    driver.quit()