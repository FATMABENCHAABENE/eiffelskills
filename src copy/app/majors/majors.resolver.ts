import { inject } from "@angular/core"
import { ResolveFn } from "@angular/router"
import { MajorService } from "services/major.service"
import { Major } from "models/major.model"

export const MajorsResolver: ResolveFn<Major[]> = () => {
  return inject(MajorService).findAll()
}
