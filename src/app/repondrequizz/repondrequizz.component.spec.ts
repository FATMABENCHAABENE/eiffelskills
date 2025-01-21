import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RepondrequizzComponent } from './repondrequizz.component';

describe('RepondrequizzComponent', () => {
  let component: RepondrequizzComponent;
  let fixture: ComponentFixture<RepondrequizzComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RepondrequizzComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RepondrequizzComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
