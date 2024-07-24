from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
from sqlalchemy.orm import Session
DATABASE_URL = "postgresql://postgres:mysecretpassword@localhost:5432/mydatabase"

engine=create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False,autoflush=False,bind=engine)
Base=declarative_base()

def get_db():
    db=SessionLocal()
    try:
        yield db
    finally:
        db.close()

class Database:
    def __init__(self):
        self.engine = engine
        self.session_local = SessionLocal
        Base.metadata.create_all(bind=self.engine)

    def get_session(self) -> Session:
        return self.session_local()