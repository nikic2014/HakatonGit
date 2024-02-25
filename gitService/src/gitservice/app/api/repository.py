from git import Repo
import requests
from src.gitservice.app.api.const import GITHUB_USERNAME, GITHUB_TOKEN, HEADERS


def create_repository(username, course_id, course_name, description):
    create_repository_url = 'https://api.github.com/user/repos'

    repository_name = f"course-{course_id}-{username}"
    repo = Repo.init(repository_name)

    headers = {
        'Authorization': f'token {GITHUB_TOKEN}',
        'Content-Type': 'application/json'
    }
    data = {
        'name': repository_name,
        'description': f"{course_name}:\n{description}",
        'private': True,
        'auto_init': True
    }

    response = requests.post(create_repository_url, headers=headers, json=data)

    if response.status_code == 201:
        add_collaborator(repository_name, username)

        return response.json()['html_url']
    elif response.status_code == 422:
        raise Exception("Репозиторий уже существует.")
    else:
        raise Exception(f"Ошибка при создании удаленного репозитория: {response.text}")


def add_collaborator(repository_name, username, permission="push"):
    add_collaborator_url = f"https://api.github.com/repos/{GITHUB_USERNAME}/{repository_name}/collaborators/{username}"
    headers = {
        "Authorization": f"Bearer {GITHUB_TOKEN}",
        "Accept": "application/vnd.github.v3+json"
    }
    data = {
        "permission": permission
    }
    response = requests.put(add_collaborator_url, headers=headers, json=data)

    if response.status_code == 201:
        print(f"Запрос на коллаборацию успешно отправлен пользователю {username}.")
    else:
        raise Exception(f"Ошибка при добавлении пользователя {username} в качестве коллаборатора: {response.text}")
