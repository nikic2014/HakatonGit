from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from fastapi import Request
import requests
import asyncio

from src.gitservice.app.api.repository import create_repository
from src.gitservice.app.api.branch import get_branch_info


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

@app.post("/get_branch_info")
async def app_get_branch_info(request: Request):
    try:
        data = await request.json()
        username = data.get("username")
        repository_url = data.get("repository_url")
        branch_name = data.get("branch_name")

        if not all([username, repository_url, branch_name]):
            raise HTTPException(status_code=400, detail="Missing required fields in JSON data")

        repository_name = repository_url.split("/")[-1]
        return get_branch_info(username, repository_name, branch_name)
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))
