from git import Repo
import requests
from src.gitservice.app.api.const import GITHUB_USERNAME, GITHUB_TOKEN, HEADERS


def create_repository(local_repo_path, repository_name, description):
    create_repository_url = 'https://api.github.com/user/repos'

    repo = Repo.init(local_repo_path)

    data = {
        'name': repository_name,
        'description': description,
        'private': False,
        'auto_init': True
    }

    response = requests.post(create_repository_url, headers=HEADERS, json=data)

    if response.status_code == 201:
        return f"Удаленный репозиторий успешно создан: {response.json()['clone_url']}"
    elif response.status_code == 422:
        return "Репозиторий уже существует."
    else:
        return f"Ошибка при создании удаленного репозитория: {response.text}"
