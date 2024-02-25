from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from fastapi import Request
import requests
import asyncio

from src.gitservice.app.api.repository import create_repository
# from src.gitservice.app.api.branch import get_branch_info, create_branch
# from src.gitservice.app.api.const import GITHUB_USERNAME, GITHUB_TOKEN, HEADERS


app = FastAPI()

back_addr = f"http://localhost:8080/"
origins = [
    back_addr,
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


@app.get("/")
async def root():
    return {"message": "git-service"}


@app.post("/create_repository")
async def app_create_repository(request: Request):
    try:
        data = await request.json()
        username = data.get("username")
        course_id = data.get("course_id")
        course_name = data.get("course_name")
        description = data.get("description")

        if not all([username, course_id, course_name, description]):
            raise HTTPException(status_code=400, detail="Missing required fields in JSON data")

        return create_repository(username, course_id, course_name, description)
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

# -----------------------------------------------------TEST------------------------------------------------------------


@app.get("/check_create_repository")
def check_create_repository():
    url = "http://127.0.0.1:8000/create_repository"
    data = {
        "username": "Razermel",
        "course_id": 127,
        "course_name": "Информационные технологии",
        "description": "Курс такой-то препод такой-то..."
    }

    response = requests.post(url, params=data)
    return response.json()



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
