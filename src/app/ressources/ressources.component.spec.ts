import { RessourcesComponent } from 'ressources/ressources.component';
import { ComponentFixture, TestBed } from '@angular/core/testing';

describe('RessourcesComponent', () => {
  let component: RessourcesComponent;
  let fixture: ComponentFixture<RessourcesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RessourcesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RessourcesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
