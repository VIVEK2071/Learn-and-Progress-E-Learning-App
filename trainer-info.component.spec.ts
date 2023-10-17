import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerInfoComponent } from './trainer-info.component';

describe('TrainerInfoComponent', () => {
  let component: TrainerInfoComponent;
  let fixture: ComponentFixture<TrainerInfoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TrainerInfoComponent]
    });
    fixture = TestBed.createComponent(TrainerInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
