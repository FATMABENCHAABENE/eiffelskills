import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowevalComponent } from './showeval.component';

describe('ShowevalComponent', () => {
  let component: ShowevalComponent;
  let fixture: ComponentFixture<ShowevalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowevalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowevalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
