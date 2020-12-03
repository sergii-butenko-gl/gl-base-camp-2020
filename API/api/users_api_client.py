import requests
from config.config import Config
from endpoints.endpoints import Endpoints

class UsersApiClient():

    @staticmethod
    def _prepare_url(url, base_url=Config.Base_URL):
        # TODO: check how to prepare url property
        # e.g. url.join(urls)
        return base_url + url

    @staticmethod
    def list_users(page):
        return requests.get(
            # url=Config.Base_URL + '/api/users'
            url=(UsersApiClient._prepare_url(Endpoints.USERS)
            ) + page
            ).json()

    @staticmethod
    def create_user(user_detail):
        return requests.post(
            url=UsersApiClient._prepare_url(Endpoints.USERS), 
            json=user_detail
            ).json()

    @staticmethod
    def update_user(user_detail, userID):
        return requests.put(
            url=(UsersApiClient._prepare_url(Endpoints.USERS)
            ) + userID, 
            json=user_detail
            ).json() 

    @staticmethod
    def update_patch_user(user_detail, userID):
        return requests.patch(
            url=(UsersApiClient._prepare_url(Endpoints.USERS)
            ) + userID, 
            json=user_detail
            ).json()

    @staticmethod
    def delete_users(userID):
        return requests.delete(
            url=(UsersApiClient._prepare_url(Endpoints.USERS)
            ) + userID
            )