from sqlalchemy import create_engine, Column
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base
# from sqlalchemy

DATABASE_URL = "postgresql://avnadmin:AVNS_HmxRJkpLOIDUVvoBSrV@binod-pg-binodmnnit2017-b27e.l.aivencloud.com:24037/defaultdb?sslmode=require"

engine = create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

