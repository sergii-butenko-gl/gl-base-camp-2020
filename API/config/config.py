import os

class Config():
    # Base_URL = 'https://reqres.in'
    Base_URL = os.getenv('TEST_BASE_URL', 'https://reqres.in')
    USER_ID = os.getenv('TUSER_ID', '2')