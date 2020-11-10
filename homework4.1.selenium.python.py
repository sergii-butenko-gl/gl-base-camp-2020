from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

driver = webdriver.Chrome('/home/serge/Desktop/tmp/chromedriver')
driver.get('https://www.google.com/')
googleSearchField = driver.find_element_by_name("q")
googleSearchField.send_keys("selenium install ubuntu python" + Keys.RETURN)
pypiLink = driver.find_element_by_css_selector("a[href*='pypi.org']")
pypiLink.click()
searchField = driver.find_element_by_id("search")
searchField.send_keys("selenium" + Keys.RETURN)
# print(driver.title)
assert "Search results · PyPI" in driver.title
searchResults = driver.find_elements(By.CSS_SELECTOR, "ul[aria-label='Search results'] li")
secondResult = searchResults[1].find_element_by_class_name("package-snippet__name")
print("----result = " + secondResult.text)
driver.close()