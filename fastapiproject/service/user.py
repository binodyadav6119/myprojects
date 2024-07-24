from sqlalchemy.orm import Session
from models.user import User
from schemas.user import UserCreate
from db import get_db,Database
from fastapi import Depends
from sqlalchemy.exc import IntegrityError
from fastapi import HTTPException

# db=get_db()
# db= Session = Depends(get_db)
# db1: Session = Depends(get_db)
dbs=Database()
dbs=dbs.session_local()
def create_user(user: UserCreate, db: Session):
    try:
        db_user=User(name=user.name,email=user.email)
        dbs.add(db_user)
        dbs.commit()
    except Exception as e:
        dbs.rollback()
        raise HTTPException(status_code=400, detail="user already exist")
    return db_user
