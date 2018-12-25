import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayItemListComponent } from './play-item-list.component';

describe('PlayItemListComponent', () => {
  let component: PlayItemListComponent;
  let fixture: ComponentFixture<PlayItemListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayItemListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayItemListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
