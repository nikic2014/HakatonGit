import requests
from src.gitservice.app.api.const import GITHUB_USERNAME, GITHUB_TOKEN, HEADERS


def get_branch_info(username, repository_name, branch_name):
    url = f"https://api.github.com/repos/{GITHUB_USERNAME}/{repository_name}/branches/{branch_name}"
    headers = {
        'Authorization': f'token {GITHUB_TOKEN}',
        'Content-Type': 'application/json'
    }
    response = requests.get(url, headers=headers)

    if response.status_code == 200:
        branch_info = response.json()
        return branch_info['commit']['commit']['author']['date']
