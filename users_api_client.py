import requests
from config.config import Config
from endpoints.endpoints import Endpoints
from urllib.parse import urljoin


class UsersApiClient():

	@staticmethod
	def _prepare_url(url,base_url=Config.BASE_URL):
		#return base_url + url
		return urljoin(base_url, url)
		
	@staticmethod
	def list_users():
		return requests.get(
			url=UsersApiClient._prepare_url(Endpoints.USERS)
			).json()

	@staticmethod
	def create_user(user_details):
		print(UsersApiClient._prepare_url(Endpoints.USERS))
		return requests.post(
			url=UsersApiClient._prepare_url(Endpoints.USERS),
			json=user_details
			).json()
	@staticmethod
	def delete_user(user_ID):
		return requests.delete(
			url=UsersApiClient._prepare_url(Endpoints.USERS)
			)
