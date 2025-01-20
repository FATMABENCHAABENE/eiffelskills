import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreerquizzComponent } from './creerquizz.component';

describe('CreerquizzComponent', () => {
  let component: CreerquizzComponent;
  let fixture: ComponentFixture<CreerquizzComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreerquizzComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreerquizzComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
