from sqlalchemy.orm import Session
from models.item import Item
from schemas.item import ItemCreate

def create_item(item: ItemCreate, db: Session):
    db_item = Item(name=item.name, description=item.description)
    db.add(db_item)
    db.commit()
    db.refresh(db_item)
    return db_item

def get_item(item_id: int, db: Session):
    return db.query(Item).filter(Item.id == item_id).first()
