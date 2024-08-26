from sqlalchemy.orm import Session
from models.user import User
from schemas.user import UserCreate

def create_user(user: UserCreate, db: Session):
    db_user = User(name=user.name, email=user.email)
    db.add(db_user)
    db.commit()
    # db.refresh(db_user)
    return db_user

def get_user(user_id: int, db: Session):
    return db.query(User).filter(User.id == user_id).first()
