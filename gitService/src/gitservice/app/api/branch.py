import requests
from src.gitservice.app.api.const import GITHUB_USERNAME, GITHUB_TOKEN, HEADERS


def get_branch_info(username, repository_name):
    """Get repository-SHA"""
    url = f"https://api.github.com/repos/{username}/{repository_name}/branches/main"
    response = requests.get(url)

    if response.status_code == 200:
        branch_info = response.json()
        return branch_info['commit']['sha']


def create_branch(username, repository_name, branch_name):
    url = f"https://api.github.com/repos/{username}/{repository_name}/git/refs"
    data = {
        "ref": f"refs/heads/{branch_name}",
        "sha": get_branch_info(username, repository_name)
    }

    response = requests.post(url, headers=HEADERS, json=data)

    if response.status_code == 201:
        return "Ссылка на ветку успешно создана."
    elif response.status_code == 422:
        return "Ветка уже существует."
    else:
        return f"Ошибка при создании ссылки на ветку: {response.text}"
