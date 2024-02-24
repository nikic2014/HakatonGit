from fastapi import FastAPI, HTTPException
import requests

from src.gitservice.app.api.repository import create_repository
# from src.gitservice.app.api.branch import get_branch_info, create_branch
# from src.gitservice.app.api.const import GITHUB_USERNAME, GITHUB_TOKEN, HEADERS


app = FastAPI()


@app.get("/")
async def root():
    return {"message": "git-service"}


@app.post("/create_repository")
def app_create_repository(username: str, course_id: int, course_name: str, description: str):
    try:
        return create_repository(username, course_id, course_name,  description)
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

# response["html_url"]

# @app.get("/get_branch_info")
# def app_get_branch_info(username: str, repository_name: str):
#     try:
#         return get_branch_info(username, repository_name)
#     except Exception as e:
#         raise HTTPException(status_code=500, detail=str(e))
#
#
# @app.post("/create_branch")
# def app_create_branch(username: str, repository_name: str, branch_name: str):
#     try:
#         return create_branch(username, repository_name, branch_name)
#     except Exception as e:
#         raise HTTPException(status_code=500, detail=str(e))
#

# -----------------------------------------------------TEST------------------------------------------------------------
@app.get("/check_create_repository")
def check_create_repository():
    url = "http://0.0.0.0:8000/create_repository"
    data = {
        "username": "Razermel",
        "course_id": "123",
        "course_name": "Информационные технологии",
        "description": "Курс такой-то препод такой-то..."
    }

    response = requests.post(url, params=data)
    return response.json()


# @app.get("/check_get_branch_info")
# def check_create_repository():
#     url = "http://0.0.0.0:8000/get_branch_info"
#     data = {
#         "username": GITHUB_USERNAME,
#         "course": "new_repository_name"
#     }
#
#     response = requests.get(url, params=data)
#     return response.json()
#
#
# @app.get("/check_create_branch")
# def check_create_branch():
#     url = "http://0.0.0.0:8000/create_branch"
#     data = {
#         "username": GITHUB_USERNAME,
#         "repository_name": "new_repository_name2",
#         "branch_name": "test"
#     }
#
#     response = requests.post(url, params=data)
#     return response.json()
