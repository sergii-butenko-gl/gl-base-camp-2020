import pytest
import requests
from config.config import Config
from api.users_api_client import UsersApiClient
from endpoints.endpoints import Endpoints

USER_ID = ''

@pytest.mark.smoke
@pytest.mark.user
def test_it_checks_user_list():
    global USER_ID
    users = UsersApiClient.list_users()
    USER_ID = str(users['data'][1]['id'])
    assert (len(USER_ID) > 0)
	
@pytest.mark.regression
@pytest.mark.user
def test_it_checks_user_created():
    user_details = {"name": "morpheus",
                    "job": "leader"
                    }
    user = UsersApiClient.create_user(user_details)
    print(user)
    assert (user['name'] == 'morpheus')

@pytest.mark.regression
@pytest.mark.user
def test_it_checks_user_delete():
	userres= UsersApiClient.delete_user(USER_ID)
	print(userres.status_code)
	assert (userres.status_code == 204)
	
