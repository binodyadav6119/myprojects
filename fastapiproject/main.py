from fastapi import FastAPI,Depends
from  db import engine,Base
from controller import user

app=FastAPI()
Base.metadata.create_all(bind=engine)

app.include_router(user.router)


