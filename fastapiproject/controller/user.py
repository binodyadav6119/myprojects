from fastapi import APIRouter,Depends
from service import user as userservice
from schemas.user import UserCreate
from sqlalchemy.orm import Session
from db import get_db
router=APIRouter()

@router.post("/test1/")
def tewt(user: UserCreate, db: Session = Depends(get_db)):
    userdetails = userservice.create_user(user,db)
    print("get user")
    print(userdetails.to_dict())
    return "testing"