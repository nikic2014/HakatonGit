## Как запустить фронт?
 1. Склонировать репозиторий к себе на ПК
 2. ``` npm install ```
 3. ``` npm run dev ```
 4. Готово!

## Как запустить бек?
1. backendJava: запустите docker-compose.yml
2. backendPython: 
```pip install rye```
```pip install uvicorn```
```pip install -r requirements.txt```
3. В дерриктории gitService/src/gitservice/app/ создать файл .env
   В нем указать ```GITHUB_USERNAME=''``` ```GITHUB_TOKEN=''``` пользователя от имени которого будут создаваться репозитории (возможно использование организации)
