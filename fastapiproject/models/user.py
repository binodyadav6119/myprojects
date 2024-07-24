from sqlalchemy import Column,Integer,String
from db import Base

class User(Base):
    __tablename__='usersss'
    
    id=Column(Integer, primary_key=True,index=True)
    name=Column(String, index=True)
    email=Column(String,unique=True,index=True)

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "email": self.email
        }