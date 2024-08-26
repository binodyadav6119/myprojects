from fastapi import FastAPI, Depends, HTTPException
from sqlalchemy.orm import Session
from crud import user as user_crud
from crud import item as item_crud
from schemas.user import UserCreate, UserResponse
from schemas.item import ItemCreate, ItemResponse
from models import user as user_model
from models import item as item_model
from db import engine, Base, get_db

app = FastAPI()

Base.metadata.create_all(bind=engine)

@app.post("/users/", response_model=UserResponse)
async def create_user(user: UserCreate, db: Session = Depends(get_db)):
    return user_crud.create_user(user, db)

@app.get("/users/{user_id}", response_model=UserResponse)
async def read_user(user_id: int, db: Session = Depends(get_db)):
    user = user_crud.get_user(user_id, db)
    print("id of user")
    print(user.to_dict())
    if user is None:
        raise HTTPException(status_code=404, detail="User not found")
    return user

@app.post("/items/", response_model=ItemResponse)
async def create_item(item: ItemCreate, db: Session = Depends(get_db)):
    return item_crud.create_item(item, db)

@app.get("/items/{item_id}", response_model=ItemResponse)
async def read_item(item_id: int, db: Session = Depends(get_db)):
    item = item_crud.get_item(item_id, db)
    if item is None:
        raise HTTPException(status_code=404, detail="Item not found")
    return item
