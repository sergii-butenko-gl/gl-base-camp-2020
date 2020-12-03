import pytest
import requests
from config.config import Config
from api.users_api_client import UsersApiClient

@pytest.mark.smoke
@pytest.mark.user
def test_it_checks_user_list():
    # res = requests.get(
    #     url=Config.Base_URL + '/api/users?page=2'
    # )
    # print(res.status_code)
    # # if res.status_code !=200:
    # #     raise Exception('non complete request')
    # res.raise_for_status()
    users = UsersApiClient.list_users("2")
    print(users)
    assert users['per_page'] == len(users['data'])

@pytest.mark.regression
@pytest.mark.user
def test_it_checks_user_created():
    # with pytest.raises(Exception):
    user_deatils = {"name": "morpheus",
                    "job": "leader"
                    }
    user = UsersApiClient.create_user(user_deatils)
    print(user)
    assert user['name'] == user_deatils['name']

@pytest.mark.regression
@pytest.mark.user
def test_it_checks_user_update():
    user_deatils = {"name": "morpheus",
                    "job": "slave"
                    }
    user = UsersApiClient.update_user(user_deatils, Config.USER_ID)
    print(user)
    assert user['job'] == user_deatils['job']

@pytest.mark.regression
@pytest.mark.user
def test_it_checks_user_update_patch():
    user_deatils = {"name": "morpheus",
                    "job": "master"
                    }
    user = UsersApiClient.update_patch_user(user_deatils, Config.USER_ID)
    print(user)
    assert user['job'] == user_deatils['job']

@pytest.mark.regression
@pytest.mark.user
def test_it_checks_user_delete():
    user = UsersApiClient.delete_users(Config.USER_ID)
    print(user.status_code)
    assert user.status_code == 204