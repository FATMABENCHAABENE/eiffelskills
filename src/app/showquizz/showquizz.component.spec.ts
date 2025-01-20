import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowquizzComponent } from './showquizz.component';

describe('ShowquizzComponent', () => {
  let component: ShowquizzComponent;
  let fixture: ComponentFixture<ShowquizzComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowquizzComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowquizzComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
