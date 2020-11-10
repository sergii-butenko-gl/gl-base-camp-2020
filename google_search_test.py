from selenium import webdriver
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome() #assuming driver is added to the environment path
url = "https://www.google.com.ua/"
driver.get(url)

#searching in google
phrase = "selenium install ubuntu python"
google_search_input = driver.find_element_by_name("q")
google_search_input.send_keys(phrase + Keys.RETURN)
desired_link = driver.find_element_by_partial_link_text("pypi.org")
desired_link.click()

#searching in opened website
pypi_search_input = driver.find_element_by_name("q")
pypi_search_input.send_keys("selenium" + Keys.RETURN)
selenium_packages = driver.find_elements_by_class_name("package-snippet")
selenium_packages[1].click()

#checking the right page is opened
page_title = driver.find_element_by_class_name("package-header__name").text
assert "amazon-selenium 0.1.2" in page_title

driver.quit()




